package farcicDev.usersSemMq.presentation.Mapper;

import farcicDev.usersSemMq.core.domain.Users;
import farcicDev.usersSemMq.presentation.dto.UsersRequest;
import farcicDev.usersSemMq.presentation.dto.UsersRespose;
import org.springframework.stereotype.Component;

@Component
public class UsersMapperDto {

    public Users toDomain(UsersRequest request){
        return new Users(
                null,
                request.email(),
                request.name(),
                request.password(),
                request.role()
        );
    }

    public UsersRespose toResponse(Users users){
        return UsersRespose.builder()
                .userId(users.userId())
                .email(users.email())
                .name(users.name())
                .role(users.role())
                .build();
    }

}
