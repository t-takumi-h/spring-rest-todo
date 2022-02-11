package com.example.springrest.controller.v1;

import com.example.springrest.model.Task;
import com.example.springrest.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class TaskController {
    private final TaskRepository repository;

    @Operation(summary = "タスクを全件取得します")
    @GetMapping("/")
    List<Task> findAll() {
        return repository.findAll();
    }

    @Operation(summary = "タスクを登録します")
    @PostMapping("/")
    Task save(@RequestBody Task task) {
        return repository.save(task);
    }

    @Operation(summary = "タスクを1件取得します")
    @GetMapping("/{id}")
    Task findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @Operation(summary = "タスクを更新します")
    @PutMapping("/{id}")
    Task save(@RequestBody Task newTask, @PathVariable Long id) {
        return repository.findById(id).map(task -> {
            task.setName(newTask.getName());
            task.setCompleted(newTask.getCompleted());
            return repository.save(task);
        }).orElseGet(() -> {
            newTask.setId(id);
            return repository.save(newTask);
        });
    }

    @Operation(summary = "タスクを削除します")
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }
}
