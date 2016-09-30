package by.epamtc.task2domparser.service.impl;

import by.epamtc.task2domparser.service.DomParser;

public class DomFactory {
	private static final DomFactory instance = new DomFactory();
	
	private DomFactory(){}
	
	public static DomFactory getInstance(){
		return instance;
	}
	
	public DomParser create(){
		return new BaseDomParser();
	}

}
