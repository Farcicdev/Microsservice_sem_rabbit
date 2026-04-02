package farcicDev.usersSemMq.infra.gatewayImpl;

import farcicDev.usersSemMq.core.UsersGateway.UsersGateway;
import farcicDev.usersSemMq.core.domain.Users;
import farcicDev.usersSemMq.infra.MapperEntity.UsersMapper;
import farcicDev.usersSemMq.infra.entity.UsersEntity;
import farcicDev.usersSemMq.infra.repository.UsersJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersGatewayImpl implements UsersGateway {

    private final UsersJpaRepository repository;

    private final UsersMapper mapper;

    @Override
    public Users save(Users users) {
        UsersEntity entity = mapper.toEntity(users);
        UsersEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Users> findByEmail(String email){
        return repository.findByEmail(email)
                .map(mapper::toDomain);
    }
    @Override
    public List<Users> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Users> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Users update(Users users, UUID id) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
