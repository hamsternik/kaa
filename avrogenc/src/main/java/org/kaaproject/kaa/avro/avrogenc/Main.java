/*
 * Copyright 2014 CyberVision, Inc.
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

package org.kaaproject.kaa.avro.avrogenc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    private Main()  {
    }

    public static void main(String[] args) {
        try {
            if (args.length < 3) {
                throw new KaaCGeneratorException("Not enough argument. "
                        + "Need {FULL_PATH_TO_SCHEMA} {OUTPUT_PATH} {SOURCE_NAME}");
            }

            Compiler compiler = new Compiler(args[0], args[1], args[2]);
            compiler.generate();
        } catch (Exception e) {
            LOG.error("Compilation failure: ", e);
            System.err.println("Compilation failure: " + e.toString());
        }
    }
}
