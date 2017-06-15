package com.project.exception;

public class VowelNotFoundException extends RuntimeException {

    private static final String VOGAL_NAO_ENCONTRADA = "Não foi encontrada vogal única precedida de consoante precedida de vogal na entrada fornecida.";

    public VowelNotFoundException() {
        super(VOGAL_NAO_ENCONTRADA);
    }
}
