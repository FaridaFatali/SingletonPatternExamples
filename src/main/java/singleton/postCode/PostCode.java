package singleton.postCode;

public class PostCode {
    private String code;

    public PostCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        PostCode other = (PostCode) obj;
        if (code == null) {
            return other.code == null;
        } else return code.equals(other.code);
    }

    @Override
    public String toString() {
        return "PostCode [code=" + code + "]";
    }
}
