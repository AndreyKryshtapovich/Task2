package by.epamtc.task2domparser.service;

import by.epamtc.task2domparser.entity.Document;

public interface DomParser {
	
	Document parse(String fileName);

}
