package com.apkaSklepu.core;

import com.apkaSklepu.model.IUser;

public interface IAuthenticator {
    void authenticate(IUser user);
}
