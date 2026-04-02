package farcicDev.usersSemMq.presentation.controller;

import farcicDev.usersSemMq.application.useCase.UsersListUserUseCase;
import farcicDev.usersSemMq.application.useCase.UsersSaveUseCase;
import farcicDev.usersSemMq.core.domain.Users;
import farcicDev.usersSemMq.presentation.Mapper.UsersMapperDto;
import farcicDev.usersSemMq.presentation.dto.UsersRequest;
import farcicDev.usersSemMq.presentation.dto.UsersRespose;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersListUserUseCase listAllUseCase;
    private final UsersSaveUseCase usersSaveUseCase;
    private final UsersMapperDto usersMapperDto;

    @PostMapping()
    public ResponseEntity<UsersRespose> save(@RequestBody @Valid UsersRequest request) {
        Users domain = usersMapperDto.toDomain(request);
        Users saved = usersSaveUseCase.execute(domain);
        return ResponseEntity.ok(usersMapperDto.toResponse(saved));
    }

    @GetMapping()
    public ResponseEntity<List<UsersRespose>> listAll() {
        return ResponseEntity.ok(listAllUseCase.execute()
                .stream()
                .map(usersMapperDto::toResponse)
                .toList()
        );
    }
}
