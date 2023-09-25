package com.abc.jdbc.util.object.login;

import com.abc.jdbc.dto.MembersDTO;

public class Status {
    private boolean success;
    private MembersDTO membersDTO;
    public Status() {}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public MembersDTO getMembersDTO() {
        return membersDTO;
    }

    public void setMembersDTO(MembersDTO membersDTO) {
        this.membersDTO = membersDTO;
    }
}
