package group.msg.at.cloud.cloudtrain.core.boundary;

import group.msg.at.cloud.cloudtrain.adapter.persistence.jpa.repository.TaskRepository;
import group.msg.at.cloud.cloudtrain.core.control.UserPermissionVerifier;
import group.msg.at.cloud.cloudtrain.core.entity.Task;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static group.msg.at.cloud.cloudtrain.MetricsConfiguration.*;

/**
 * Simple {@code Boundary} that manages {@code Task} entities.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
@Secured("CLOUDTRAIN_USER")
public class TaskManagement {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private UserPermissionVerifier verifier;

    @NotNull
    @Counted(value = BUSINESS_OPERATION_METRIC_PREFIX, extraTags = {BUSINESS_OPERATION_NAME_TAG, "task_add"})
    @Timed(value = BUSINESS_OPERATION_METRIC_PREFIX, extraTags = {BUSINESS_OPERATION_NAME_TAG, "task_add"})
    public UUID addTask(@NotNull @Valid Task newTask) {
        verifier.requirePermission("TASK_CREATE");
        Task saved = this.repository.saveAndFlush(newTask);
        return saved.getId();
    }

    @Counted(value = BUSINESS_OPERATION_METRIC_PREFIX, extraTags = {BUSINESS_OPERATION_NAME_TAG, "task_modify"})
    @Timed(value = BUSINESS_OPERATION_METRIC_PREFIX, extraTags = {BUSINESS_OPERATION_NAME_TAG, "task_modify"})
    public void modifyTask(@NotNull @Valid Task modifiedTask) {
        verifier.requirePermission("TASK_UPDATE");
        this.repository.save(modifiedTask);
    }

    @Counted(value = BUSINESS_OPERATION_METRIC_PREFIX, extraTags = {BUSINESS_OPERATION_NAME_TAG, "task_get"})
    @Timed(value = BUSINESS_OPERATION_METRIC_PREFIX, extraTags = {BUSINESS_OPERATION_NAME_TAG, "task_get"})
    public Optional<Task> getTaskById(@NotNull UUID taskId) {
        verifier.requirePermission("TASK_READ");
        return this.repository.findById(taskId);
    }

    @Counted(value = BUSINESS_OPERATION_METRIC_PREFIX, extraTags = {BUSINESS_OPERATION_NAME_TAG, "task_delete"})
    @Timed(value = BUSINESS_OPERATION_METRIC_PREFIX, extraTags = {BUSINESS_OPERATION_NAME_TAG, "task_delete"})
    public void removeTask(@NotNull UUID taskId) {
        verifier.requirePermission("TASK_DELETE");
        this.repository.deleteById(taskId);
    }

    @Counted(value = BUSINESS_OPERATION_METRIC_PREFIX, extraTags = {BUSINESS_OPERATION_NAME_TAG, "task_browse"})
    @Timed(value = BUSINESS_OPERATION_METRIC_PREFIX, extraTags = {BUSINESS_OPERATION_NAME_TAG, "task_browse"})
    public List<Task> getAllTasks() {
        verifier.requirePermission("TASK_READ");
        return this.repository.findAll();
    }
}
