package mx.edu.uacm.alarma.mx.edu.uacm.alarma.api;

import mx.edu.uacm.alarma.model.Login;
import mx.edu.uacm.alarma.model.SignupRequest;
import mx.edu.uacm.alarma.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PostService {

    String API_ROUTE = "api/auth/signup";
    String LOGIN_ROUTE ="api/auth/signin";
    @Headers({

            "Content-type: application/json"

    })
    @POST(API_ROUTE)
    Call<SignupRequest> sendPosts(@Body SignupRequest signup);

    @POST(LOGIN_ROUTE)
    Call<User> sendPostLogin(@Body Login login);

}
