package farcicDev.usersSemMq.infra.MapperEntity;

import farcicDev.usersSemMq.core.domain.Users;
import farcicDev.usersSemMq.infra.entity.UsersEntity;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    public Users toDomain(UsersEntity entity) {
       return new Users(
                entity.getUserId(),
                entity.getEmail(),
                entity.getName(),
                entity.getPassword(),
                entity.getRole()
       );
    }

    public UsersEntity toEntity(Users users){
        return UsersEntity.builder()
                .userId(users.userId())
                .email(users.email())
                .name(users.name())
                .password(users.password())
                .role(users.role())
                .build();
    }

}
