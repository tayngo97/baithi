package com.stdio.esm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
/**
 * @author AnhKhoa
 * @since 19/05/2022 - 11:11
 */
@Entity
@Table(name = "accounts_roles")
@Data
public class AccountRole {
    @EmbeddedId
    private AccountRoleId accountRoleId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Account account;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Role role;

    @Embeddable
    @Data
    public static class AccountRoleId implements Serializable {

        private static final long serialVersionUID = -8886468907100754072L;

        @Column(name = "account_id")
        private Long account_id;

        @Column(name = "role_id")
        private Long role_id;
    }

}
