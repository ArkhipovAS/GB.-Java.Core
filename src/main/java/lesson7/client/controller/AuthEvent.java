package lesson7.client.controller;

@FunctionalInterface
public interface AuthEvent {
    void authIsSuccessful(String nickname);
}
