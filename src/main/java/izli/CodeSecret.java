package izli;

import java.util.Objects;
import java.util.Random;

public class CodeSecret {
    private final String code;
    private boolean codeRevele;
    private int nbEssaiConsecutifs;

    public CodeSecret(String code) {
        this.code = code;
    }

    public boolean verifierCode(String code) throws CodeBloqueException {
        if (isBloqued()) throw new CodeBloqueException();
        if (this.code.equals(code)) {
            nbEssaiConsecutifs = 0;
            return true;
        } else {
            nbEssaiConsecutifs++;
            return false;
        }
    }

    public boolean isBloqued() {
        return nbEssaiConsecutifs >= 3;
    }
}