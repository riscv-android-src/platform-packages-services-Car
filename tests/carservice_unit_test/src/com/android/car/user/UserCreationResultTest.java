/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.car.user;

import static android.car.user.UserCreationResult.STATUS_ANDROID_FAILURE;
import static android.car.user.UserCreationResult.STATUS_HAL_FAILURE;
import static android.car.user.UserCreationResult.STATUS_HAL_INTERNAL_FAILURE;
import static android.car.user.UserCreationResult.STATUS_SUCCESSFUL;

import static com.google.common.truth.Truth.assertThat;

import android.car.user.UserCreationResult;

import org.junit.Test;

public final class UserCreationResultTest {

    @Test
    public void testIsSuccess() {
        assertThat(new UserCreationResult(STATUS_SUCCESSFUL).isSuccess()).isTrue();
        assertThat(new UserCreationResult(STATUS_SUCCESSFUL, null, null).isSuccess()).isTrue();
        assertThat(new UserCreationResult(STATUS_HAL_FAILURE, null, null).isSuccess()).isFalse();
        assertThat(new UserCreationResult(STATUS_HAL_FAILURE).isSuccess()).isFalse();
        assertThat(new UserCreationResult(STATUS_HAL_INTERNAL_FAILURE, null, null).isSuccess())
                .isFalse();
        assertThat(new UserCreationResult(STATUS_HAL_INTERNAL_FAILURE).isSuccess()).isFalse();
        assertThat(new UserCreationResult(STATUS_ANDROID_FAILURE, null, null).isSuccess())
                .isFalse();
        assertThat(new UserCreationResult(STATUS_ANDROID_FAILURE).isSuccess()).isFalse();
    }
}
