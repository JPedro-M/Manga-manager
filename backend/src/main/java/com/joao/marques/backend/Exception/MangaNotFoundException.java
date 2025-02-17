package com.joao.marques.backend.Exception;

public class MangaNotFoundException extends RuntimeException {
	public MangaNotFoundException(String message) {
		super(message);
	}
}
