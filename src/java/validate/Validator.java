
package validate;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Anand 
 * 
 */
public class Validator {

    public boolean validateQuantity (String productId, String quantity) {

        boolean errorFlag = false;

        if (!productId.isEmpty() && !quantity.isEmpty()) {

            int i = -1;

            try {

                i = Integer.parseInt(quantity);
            } catch (NumberFormatException nfe) {

                System.out.println("Wrong Input please enter a number");
            }

            if (i < 0 || i > 99) {

                errorFlag = true;
            }
        }

        return errorFlag;
    }


    // performs simple validation on checkout form
    public boolean validateForm(String name,
                                String email,
                                String phone,
                                String address,
                                String ccNumber,
                                Map sessionMap) {

        boolean errorFlag = false;
        boolean nameError;
        boolean emailError;
        boolean phoneError;
        boolean addressError;
        boolean ccNumberError;

        if (name == null
                || name.equals("")
                || name.length() > 45) {
            errorFlag = true;
            nameError = true;
            sessionMap.put("nameError", nameError);
        }
        if (email == null
                || email.equals("")
                || !email.contains("@")) {
            errorFlag = true;
            emailError = true;
            sessionMap.put("emailError", emailError);
        }
        if (phone == null
                || phone.equals("")
                || phone.length() < 8) {
            errorFlag = true;
            phoneError = true;
            sessionMap.put("phoneError", phoneError);
        }
        if (address == null
                || address.equals("")
                || address.length() > 45) {
            errorFlag = true;
            addressError = true;
            sessionMap.put("addressError", addressError);
        }
        return errorFlag;
    }

     public boolean validateRegisteration(String name,
                                String email,
                                String phone,
                                String password,
                                String confirm,
                                String address,
                                String username,
                                Map request) {

        boolean errorFlag = false;
        boolean nameError;
        boolean emailError;
        boolean phoneError;
        boolean addressError;
        boolean usernameError;
        boolean passworderror;

        if (name == null
                || name.equals("")
                || name.length() > 45) {
            errorFlag = true;
            nameError = true;
            request.put("nameError", nameError);
        }
        if (email == null
                || email.equals("")
                || !email.contains("@")) {
            errorFlag = true;
            emailError = true;
            request.put("emailError", emailError);
        }
        if (phone == null
                || phone.equals("")
                || phone.length() < 8) {
            errorFlag = true;
            phoneError = true;
            request.put("phoneError", phoneError);
        }
        if (address == null
                || address.equals("")
                || address.length() > 45) {
            errorFlag = true;
            addressError = true;
            request.put("addressError", addressError);
        }

        return errorFlag;
    }
}