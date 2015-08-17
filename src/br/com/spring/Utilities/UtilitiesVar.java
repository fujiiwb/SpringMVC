package br.com.spring.Utilities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class UtilitiesVar implements Serializable {

    private static final long serialVersionUID = -9175555513315137252L;
    private static final String PAGE_FORMAT = "jsp";
    public static final String SEPARATOR = "----------------------------------------------------------------------------------------------------";
    public static final Locale LOCALE_BR = new Locale("pt", "BR");
    public static final SimpleDateFormat DF_TIMESTAMP = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", LOCALE_BR);
    public static final SimpleDateFormat DF_DATE = new SimpleDateFormat("dd/MM/yyyy", LOCALE_BR);
    public static final SimpleDateFormat DF_HOUR = new SimpleDateFormat("HH:mm:ss", LOCALE_BR);

    static {
        DF_TIMESTAMP.setLenient(Boolean.FALSE);
        DF_DATE.setLenient(Boolean.FALSE);
        DF_HOUR.setLenient(Boolean.FALSE);
    }

    public static String getSeparator(int i) {
        String separator = "";
        for (int j = 0; j < i; j++) {
            separator += SEPARATOR;
        }
        return separator;
    }

    public static String getPage(String page) {
        page = PAGE_FORMAT + "/" + page + "." + PAGE_FORMAT;
        System.out.println("Redirecting: " + page);
        return page;
    }
    
    public static String getErrorMessage(String error) {
        return "Ocorreu um erro " + (error == null || error.trim().equals("") ? "nesta requisição" : error) + ". Contate o Administrador do sistema.";
    }
}
