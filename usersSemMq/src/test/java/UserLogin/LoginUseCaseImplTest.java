//package UserLogin;
//
//import farcicDev.usersSemMq.application.userCaseImpl.LoginUseCaseImpl;
//import farcicDev.usersSemMq.core.UsersGateway.UsersGateway;
//import farcicDev.usersSemMq.core.domain.Role;
//import farcicDev.usersSemMq.core.domain.Users;
//import farcicDev.usersSemMq.presentation.dto.LoginRequest;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import static org.mockito.Mockito.when;
//
//
//@ExtendWith(MockitoExtension.class)
//public class LoginUseCaseImplTest {
//
//    @Mock
//    private UsersGateway usersGateway;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private LoginUseCaseImpl loginUseCaseImpl;
//
//    @Test
//    void shouldLoginSuccessfully() {
//        LoginRequest request = new LoginRequest("teste@teste.com.br", "123456");
//
//        Users user = new Users(
//                null,
//                "teste@teste.com.brr",
//                "AUGUSTO",
//                "123456",
//                Role.ADMIN
//        );
//
//        when(usersGateway.findByEmail(request.email())).thenReturn(user);
//        when(passwordEncoder.matches(request.password(), user.getPassword())).thenReturn(true);
//
//    }
//}
