package id.co.swamedia.starter.service;

public interface MessageService {
    String getMessage(String code);
    String getMessage(String code, Object[] args);
}