package com.mysh.shareHouse.config.oauth;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.mysh.shareHouse.config.auth.PrincipalDetails;
import com.mysh.shareHouse.config.oauth.provider.FaceBookUserInfo;
import com.mysh.shareHouse.config.oauth.provider.GoogleUserInfo;
import com.mysh.shareHouse.config.oauth.provider.OAuth2UserInfo;
import com.mysh.shareHouse.model.User;
import com.mysh.shareHouse.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

	private static final Logger log = LoggerFactory.getLogger(PrincipalOauth2UserService.class);
	private final UserRepository userRepository;

	// userRequest 는 code를 받아서 accessToken을 응답 받은 객체
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		OAuth2User oAuth2User = super.loadUser(userRequest); // google의 회원 프로필 조회
		log.info("userRequest clientRegistration : " + userRequest.getClientRegistration());
		log.info("oAuth2User : " + oAuth2User);
		return processOAuth2User(userRequest, oAuth2User);
		
	}

	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {

		// Attribute를 파싱해서 공통 객체로 묶는다. 관리가 편함.
		OAuth2UserInfo oAuth2UserInfo = null;
		if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
		} else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")) {
			oAuth2UserInfo = new FaceBookUserInfo(oAuth2User.getAttributes());
		} else {
			System.out.println("지원하지 않는 OAuth2.0");
		}

		Optional<User> userOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail());
		
		User user;
		if (userOptional.isPresent()) {
			user = userOptional.get().setProvider(oAuth2UserInfo.getProvider());
		} else {
			// user의 패스워드가 null이기 때문에 OAuth 유저는 일반적인 로그인을 할 수 없음.
			user = User
					.builder()
					.userName(oAuth2UserInfo.getProvider() + "_" + oAuth2UserInfo.getName())
					.password("")
					.email(oAuth2UserInfo.getEmail())
					.phNum(000000)
					.address("")
					.bankName("")
					.roleType("USER")
					.provider(oAuth2UserInfo.getProvider())
					.providerId(oAuth2UserInfo.getProviderId())
					.build();
			userRepository.signUp(user);
			
		}

		return new PrincipalDetails(user, oAuth2User.getAttributes());
	}
}
