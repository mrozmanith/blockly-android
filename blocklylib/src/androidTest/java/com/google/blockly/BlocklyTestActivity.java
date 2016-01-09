/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.google.blockly;

import android.support.annotation.NonNull;
import com.google.blockly.utils.CodeGenerationRequest;

/**
 * Simplest implementation of AbstractBlocklyActivity using mock block definitions.
 */
public class BlocklyTestActivity extends AbstractBlocklyActivity {
    private static final String TAG = "SimpleActivity";

    CodeGenerationRequest.CodeGeneratorCallback mCodeGeneratorCallback =
            new LoggingCodeGeneratorCallback(this, TAG);

    @Override
    protected String getWorkspaceToolboxPath() {
        return "default/toolbox.xml";
    }

    @Override
    protected String getWorkspaceBlocksPath() {
        return "default/toolbox_blocks.json";
    }

    @Override
    protected String getStartingWorkspacePath() {
        return "default/demo_workspace.xml";
    }

    @NonNull
    protected String getGeneratorJsFilename() {
        return "sample_sections/generators.js";
    }

    @NonNull
    protected String getBlockDefinitionsFilename() {
        return "sample_sections/definitions.json";
    }

    @NonNull
    @Override
    protected CodeGenerationRequest.CodeGeneratorCallback getCreateCodeGenerationCallback() {
        // Uses the same callback for every generation call.
        return mCodeGeneratorCallback;
    }
}