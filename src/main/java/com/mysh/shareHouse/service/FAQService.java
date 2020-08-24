package com.mysh.shareHouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysh.shareHouse.model.Faq;
import com.mysh.shareHouse.repository.FAQRepository;

@Service
public class FAQService {
	
	@Autowired
	private FAQRepository faqRepository;
	
	@Transactional(readOnly = true)
	public List<Faq> findAll() {
		return faqRepository.findAll();
	}
	
	@Transactional
	public void delete(int id) {
		faqRepository.deleteById(id);
	}
	
	@Transactional
	public void update(Faq faq) {
		faqRepository.update(faq);
	}
}
