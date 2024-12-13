package org.example.interviewmanagement.entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AuditLogs")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auditId;

    private String action;

    private String tableName;

    private Integer recordId;

    private LocalDateTime performedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "performedBy")
    private User performedBy;
}

