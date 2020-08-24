package com.mysh.shareHouse.repository;

import java.util.List;

import com.mysh.shareHouse.model.Faq;

public interface FAQRepository {

	public List<Faq> findAll();
	public void update(Faq faq);
	public void deleteById(int id);
	
}
