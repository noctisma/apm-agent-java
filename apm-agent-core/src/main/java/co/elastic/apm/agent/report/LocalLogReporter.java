/*-
 * #%L
 * Elastic APM Java agent
 * %%
 * Copyright (C) 2018 - 2019 Elastic and contributors
 * %%
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
 * #L%
 */
package co.elastic.apm.agent.report;

import co.elastic.apm.agent.impl.error.ErrorCapture;
import co.elastic.apm.agent.impl.transaction.Span;
import co.elastic.apm.agent.impl.transaction.Transaction;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stagemonitor.util.IOUtils;

import java.io.ByteArrayInputStream;
import java.util.concurrent.Future;

public class LocalLogReporter implements Reporter{

    private static final Logger transLog = LoggerFactory.getLogger("SOPHON_TRANS");
    private static final Logger spanLog = LoggerFactory.getLogger("SOPHON_SPAN");


    @Override
    public void report(Transaction transaction) {
        transLog.info(transaction.toString());
        transLog.info(JSON.toJSONString(transaction.getContext().getCustom()));
    }

    @Override
    public void report(Span span) {
        transLog.info(span.toString());
        spanLog.info(JSON.toJSONString(span.getContext().toString()));
    }

    @Override
    public long getDropped() {
        return 0;
    }

    @Override
    public long getReported() {
        return 0;
    }

    @Override
    public Future<Void> flush() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void report(ErrorCapture error) {

    }
}
