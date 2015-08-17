package br.com.spring.exception;

public class DAOException extends Exception {

    private static final long serialVersionUID = 9218744254000329874L;
    private String method;

    public DAOException() {
        super();
    }

    public DAOException(String message, Throwable cause, Boolean enableSuppression, Boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(Throwable cause, String method) {
        super(cause);
        this.method = method;
    }

    @Override
    public void printStackTrace() {
        if (getMessage().contains("duplicate key value violates unique constraint")) {
            String stackTrace = "[DAOException][printStackTrace] " + method + "\n";
            stackTrace += "[DAOException][printStackTrace] Violação de Constraint: ";
            for (String string : getMessage().split("\n")) {
                if (string.contains("duplicate key value violates unique constraint")) {
                    stackTrace += string.substring(string.indexOf("\"") + 1, string.length() - 1);
                } else if (string.contains(" already exists")) {
                    stackTrace += " (" + string.substring(string.indexOf("(") + 1, string.lastIndexOf(")")).replaceAll("\\(|\\)", " ")+ ")";
                    break;
                }
            }
            System.err.println(stackTrace);
        } else {
            super.printStackTrace();
        }
    }
}
