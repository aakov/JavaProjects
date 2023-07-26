import java.util.List;

public class AmbigiousProductException extends  Exception{
    List<String> errors;

    public AmbigiousProductException(List<String> errors) {
        this.errors = errors;
        System.out.println(errors);
    }

    @Override
    public String getMessage() {
        return errors.toString();
    }
}
