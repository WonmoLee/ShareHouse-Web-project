# MySQL Schema

``` mysql
-유저 생성 및 권한주기와 관련 DB생성-
create user 'shareHouse'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'shareHouse'@'%';
create database shareHouse;
use shareHouse;


-interview 테이블 생성-
create table interview(
	id int auto_increment primary key,
    URL BLOB not null,
    img BLOB not null,
    title varchar(100) not null,
    create_date timestamp
) engine=InnoDB default charset=utf8;


-FAQ 테이블 생성-
create table FAQ(
   	id int auto_increment primary key,
    type varchar(100) not null,
    title varchar(1000) unique not null,
    content BLOB not null,
    create_date timestamp
) engine=InnoDB default charset=utf8;


-house_detail 테이블 생성-
create table house_detail(
   	id int auto_increment primary key,
    house_num int unique,
    img1 varchar(100),
    img2 varchar(100),
    img3 varchar(100),
    title varchar(200) not null,
    content BLOB not null,
    hash_tag varchar(100),
    tourPoint BLOB not null,
    address varchar(100) not null,
    gender char not null,
   	contractEndDate varchar(100) not null,
    maxResidencePersonnel int not null,
    house_form varchar(50) not null,
    construction varchar(100) not null,
    drawing varchar(100) not null,
    roomName varchar(100) not null,
    type varchar(100) not null,
    area varchar(100) not null,
    deposit varchar(100) not null,
    monthly varchar(100) not null,
    moveInDate varchar(100) not null,
    tourApply BLOB not null,
    subway varchar(100) not null,
    bus varchar(100) not null,
    university varchar(100),
    mart varchar(100) not null,
    facilities varchar(100) not null,
    heal varchar(100) not null,
    create_date timeStamp 
) engine=InnoDB default charset=utf8;


-테이블 삭제-
drop table interview;
drop table faq;


-테이블 조회-
select * from interview;
drop table faq;


-더미데이터-
#interview
insert into interview(id, URL, img, title, create_date) values (1, 'http://blog.naver.com/woozoo_ok/220954564793', 'https://s3.ap-northeast-2.amazonaws.com/woozoo/layout_images/main_contents/blog4.png', '"우주의 진짜 이야기"\n44호점 우주인님들', now());
insert into interview(id, URL, img, title, create_date) values (2, 'http://blog.naver.com/woozoo_ok/221474398524', 'https://s3.ap-northeast-2.amazonaws.com/woozoo/layout_images/main_contents/blog5.png', '"우주에서 오래 지내고싶어"\n한*수 우주인님', now());
insert into interview(id, URL, img, title, create_date) values (3, 'http://blog.naver.com/woozoo_ok/221502553714', 'https://s3.ap-northeast-2.amazonaws.com/woozoo/layout_images/main_contents/blog6.png', '"2년 4개월의 성수동 스토리"\n서*연 우주인님', now());
insert into interview(id, URL, img, title, create_date) values (4, 'http://blog.naver.com/woozoo_ok/221084128198', 'https://s3.ap-northeast-2.amazonaws.com/woozoo/layout_images/main_contents/blog2.jpg', '"우주를 추억하며"\n이*정 우주인님', now());


#faq(입주)
insert into faq(id, type, title, content, create_date) values (1, '입주', '1.입주신청서를 제출했습니다. 이후 과정은 어떻게 되나요?', '입주 신청서를 제출하면 접수 확인 문자가 발송됩니다. 신규 지점을 신청하신 경우 본인이 선택한 우주 하우스 투어 하루 전 날 확인 전화를 드리며, <br>             
                기존 지점을 신청하신 경우 입주 신청 후 2 일 내에 하우스 매니저가 우주 하우스 투어 일정 조율을 위해 전화를 드립니다.<br>
                우주 하우스 투어 일정이 확정되면 해당 일시에 희망 지점을 방문하여 집을 둘러보고, 하우스 매니저와 간단한 인터뷰 시간을 가지게 됩니다.', now());
insert into faq(id, type, title, content, create_date) values (2, '입주', '2. 보증금과 월세 외에 다른 비용에는 무엇이 있나요?', '<span style="color:red"> 지점 운영 관리비</span>와 <span style="color:red">선불 공과금(전기, 가스, 수도요금, 건물관리비)</span>을 별도로  납부 해주셔야 합니다. <b>[<a id="faq-link4">선불공과금이란?</a>]</b><br>
                    계약기간 내 납부해주신 <span style="color:red"> 선불 공과금은 퇴실 시 정산하고 정산후  생긴 차액은 반환 되거나 혹은 보증금에서 차감됩니다. </span><br>
                    공과금의  경우, 정산 방식은 1(쉐어하우스 인원수)/ N(실제공과금)로 사용하시는만큼 청구가 됩니다. <br> 
                    청구된 공과금은 입주자 분들의 납부 및 정산 편의를 위해 매달 임대료(월세)와 별도로 받고 있습니다.  <br> 
                    일반적으로, 운영관리비는 3만원, 선불공과금은 5만원이지만 해당 금액은 지점별로 상이할 수 있으니 이 점 꼭 참고해주세요!', now());
insert into faq(id, type, title, content, create_date) values (3, '입주', '3. 공과금은 어떻게 처리하나요?', '계약 시 안내 된 선불 공과금을 매월 납부하고 퇴실 시에	실제 사용금액과 비교해 정산하게 됩니다.', now());
insert into faq(id, type, title, content, create_date) values (4, '입주', '4. 공과금을 왜 "선불 공과금"이라고 부르나요? 이게 왜 필요하죠?', '선불 공과금이란 입주 계약기간 동안 일정 금액으로 정해진 예상 공과금을  <span style="color:red">선불로 납부하는 것</span>을 말합니다. <br>
                              사용량만큼 후불로 청구되는 공과금 특성 상, 매월 다른 금액이 청구되어 정기 요금 납부 때마다 일일이 액수를 신경 써야 한다는 불편이 있습니다. 
                              우주는 이 점을 개선하고자  <span style="color:red">우주인이 미리 지정된 고정 금액을 매달 선불로 납부하는 방식</span>으로 공과금 제도를 운영하고 있습니다.<br>', now());
insert into faq(id, type, title, content, create_date) values (5, '입주', '5. 선불 공과금과 실제 사용금액에 차이가 나면 어떻게 하나요?', '납부한 선불 공과금은 퇴실 시 실제 사용금액과 비교되어 정산됩니다.<br>
                          계약기간 동안 납부한 선불 공과금보다 실제 사용금액이 적은 경우, 퇴실 후 보증금 반환시 차액만큼 더 반환됩니다. <br>
                          반대로 실제 사용금액이 더 많은 경우, 보증금이 차액만큼 차감되어 반환됩니다 ', now());
insert into faq(id, type, title, content, create_date) values (6, '입주', '6. 공과금은 어떤 절차로 납부하나요?', '임대료와 동일하게 우주가 안내하는 대로 납부하시면 됩니다. 단, 실제로 거주했는지 여부와 관계 없이 계약기간을 기준으로 부담하는 것이 원칙입니다.<br> 
                            즉, 계약기간 중 개인사정으로 집을 비우는 기간이 발생하더라도 해당기간이 공과금 산정기간에서 제외되지 않습니다.', now());
insert into faq(id, type, title, content, create_date) values (7, '입주', '7. 보증금은 언제 반환되나요?', '보증금은 퇴실 시 시행하는 하우스 매니저의 시설 점검 후 3일 내에 반환해드립니다. <br>
                              다만 보증금은 다음의 두 가지 사유로 차감될 수 있으며 다음에 해당하는 사례의 경우 잔여 액만 반환 가능합니다. <br>
                              ① 임대료가1개월 이상 체납되는 경우 변제 <br>
                              ② 입주자 과실로 시설/기물이 파손되는 경우 배상 ', now());
insert into faq(id, type, title, content, create_date) values (8, '입주', '8. 퇴실 절차는 어떻게 되나요?', 'WOOZOO는 현재 입주자 분께 계약 종료일로부터 2개월 전에 재계약 의사를 문의 드리며, 재계약 의사가 없으실 경우, 계약종료일에 하우스 매니저의 시설 점검을 후 시설에 이상이 없을 시 퇴실 하게 됩니다. 퇴실 시 열쇠는 반납하셔야 하며, 보증금은 계약종료일로부터 3 일 이내에 돌려드립니다.', now());
insert into faq(id, type, title, content, create_date) values (9, '입주', '9. 입주 시 지켜야 할 규정이 있나요?', '계약사항에 위배되지 않는한 WOOZOO는 입주자분들의 개인생활에 관여하지 않습니다. <br>
                                    다만, 같은 지점에 거주하는우주인들은 입주 후 협의 하에 ‘주거규칙 가이드라인’을 만들어 원활한 셰어 라이프를 지켜나갑니다.', now());
insert into faq(id, type, title, content, create_date) values (10, '입주', '10. 입주 후 추가 수납공간 및 기타 시설이 필요할 경우 어떻게 하나요?', '계약 전 우주 하우스 투어를 통해 수납공간과 시설에 대한 충분한 숙지 후 계약을 진행하므로 WOOZOO는 입주 후 추가 시설 또는 기타 물품 (수납장, 정수기 등)
                                      에 대한 지원을 진행하지 않습니다. 이 점 양해 부탁 드립니다!', now());
insert into faq(id, type, title, content, create_date) values (11, '입주', '11. 입주 시 꼭 챙겨야 하는 물건이 있나요?', '기본적인 가전제품과 가구만 준비되어 있으므로 그 외의 물품은 모두 개인적으로 준비하셔야 합니다. <br> <br>
                                      <ul>
                                      <li>개인식기 (수저, 그릇, 조리기구) </li> 
                                      <li>침구 (매트리스 커버, 이불, 베개) </li> 
                                      <li>개인 스탠드, 멀티탭 </li> 
                                      <li>빨래건조대는 공용으로 2~4개가 준비되어 있습니다. </li> 
                                      </ul>', now());
insert into faq(id, type, title, content, create_date) values (12, '입주', '12. 반려동물/애완동물을 키울 수 있나요?', '크기와 종류에 관계 없이 모든 반려/애완동물을 키울 수 없으며, 이를 위반할 경우 계약 내용에 따라 퇴거요청을 받을 수 있습니다. <br>
                                          이는 룸메이트나 해당 집의 입주자 전원이 동의하더라도 마찬가지입니다.', now());


#faq(계약)
insert into faq(id, type, title, content, create_date) values (13, '계약', '1. 계약기간은 어떻게 되나요?', '입주 계약은 6개월 단위로 체결 가능합니다. WOOZOO HOUSE는 거주자 커뮤니티 형성과 셰어하우스 문화정착을 위해 6개월 단위로 거주 계약을 집행하고 있으며, <br>
               6개월 미만의 단기 계약은 현재로서는 불가능합니다. 향후 지원 여부를 검토 중이니 지원이 가능할 시 공지드리도록 하겠습니다.', now());
insert into faq(id, type, title, content, create_date) values (14, '계약', '2. 입주일은 어떻게 정해지나요?', '입주일은 하우스 매니저와의 일정 조율을 통해 정해지나, <br>통상 입주 가능일로부터 7일 이내에 입주 가능하신 분이 희망 지점 입주에 유리합니다. <br>
                계약서를 작성 하고 나면 2일 이내에 보증금을 납부하셔야 하며, 월세는 입주 2일 전까지 납부해야 합니다.<br>
                위 사항을 지키지 못 하실 경우 계약은 통보 없이 자동으로 취소되오니, 이 점 양해 부탁 드립니다.<br>', now());
insert into faq(id, type, title, content, create_date) values (15, '계약', '3. 입주기간을 연장할 수 있나요?', '입주기간은 초기 계약과 마찬가지로 6개월 단위로 연장하게 됩니다. 재계약을 원하실 경우, 계약 종료일로부터 두 달 전에 하우스 매니저께 재계약 의사를
                밝혀주셔야 하며, 재계약은 입주자 간 상호 만족도 조사와 담당자 소견을 바탕으로 결정됩니다.', now());
insert into faq(id, type, title, content, create_date) values (16, '계약', '4. 보증금은 납부하였으나 아직 입주 전 입니다. 만약 현 상황에서 계약 취소 시 어떻게 되나요?', '입주 전 계약을 해지하는 경우, 계약시작일까지 남은 기간에 따라 다른 액수의 보증금이 차감됩니다. 자세한 사항은 계약서를 참조하시기 바랍니다.', now());
insert into faq(id, type, title, content, create_date) values (17, '계약', '5. 보증금과 월세는 얼마인가요?', '임대료는 집에 따라 다르기 때문에, 입주를 희망하시는 집의 상세 소개페이지에서 확인해주시는 것이 가장 정확합니다.
                마찬가지로 보증금도 집에 따라 달라지며, 입주를 희망하시는 방 월세의 2개월 분 금액입니다.
                (예를 들어 월세가 40만원인 방에 입주 하시면, 보증금은 80만원입니다.)', noew());
insert into faq(id, type, title, content, create_date) values (18, '계약', '6. 단기 입주가 가능한가요?', '우주는 초기 입주 시 6개월 계약을 원칙으로 하고 있습니다. 90일 미만의 단기 입주계약은 불가하며,
                  3~6개월 사이의 계약을 원하시는 경우 실제 계약 가능 여부는 우주가 판단하여 진행합니다.', now());
insert into faq(id, type, title, content, create_date) values (19, '계약', '7. 입주할 수 있는 나이 제한이 있나요?', '보다 빠르고 친밀한 커뮤니티 형성을 위해, 입주하시는 분들의 연령은 20세부터 41세까지로 정하고 있습니다.', now());
insert into faq(id, type, title, content, create_date) values (20, '계약', '8. 입주 및 계약 문의는 어디로 해야하나요?', '입주/계약문의는 전화(010-3042-5161) 및 이메일(living@woozoo.kr) 로 영업시간(오전10시-오후6시)내에 문의하실 수 있습니다. 
               입주/계약에 대한 궁금하신 점은 홈페이지의 FAQ를 통해 확인 하실 수 있으니 문의하시기 전에 FAQ를 확인해주세요! 
                카카오톡 혹은 라인 메신저로는 상담 진행해드리지 않고 있으니 이 점 참고 부탁드립니다.', now());
insert into faq(id, type, title, content, create_date) values (21, '계약', '9. 2인실 가격 기준은 어떻게 되나요?', '입주일은 하우스 매니저와의 일정 조율을 통해 정해지나, <br>통상 입주 가능일로부터 7일 이내에 입주 가능하신 분이 희망 지점 입주에 유리합니다. <br>
               계약서를 작성 하고 나면 2일 이내에 보증금을 납부하셔야 하며, 월세는 입주 2일 전까지 납부해야 합니다.<br>
               위 사항을 지키지 못 하실 경우 계약은 통보 없이 자동으로 취소되오니, 이 점 양해 부탁 드립니다.<br>', now());
insert into faq(id, type, title, content, create_date) values (22, '계약', '10. 지점 내 관리 직원이 상주하나요?', '아니오. 지점 내에서는 우주 직원이 상주하고 있지 않습니다.', now());

#개행문자
update interview set title = replace(title, '&nbsp;', 'CHAR(10)');
```



