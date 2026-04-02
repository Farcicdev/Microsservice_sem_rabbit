package farcicDev.usersSemMq.core.UsersGateway;

import farcicDev.usersSemMq.core.domain.Users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersGateway {

    //findByEmail
    Optional<Users> findByEmail(String email);
    //criar
    Users save(Users users);
    //listar
    List<Users> findAll();
    //listar por id
    Optional<Users> findById(UUID id);
    //atualizar
    Users update(Users users, UUID id);
    //deletar
    void deleteById(UUID id);


}
