/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.sdk.extensions.sql.impl.rule;

import org.apache.beam.sdk.extensions.sql.impl.rel.BeamCalcRel;
import org.apache.beam.vendor.calcite.v1_20_0.org.apache.calcite.plan.RelOptRule;
import org.apache.beam.vendor.calcite.v1_20_0.org.apache.calcite.plan.RelOptRuleCall;
import org.apache.beam.vendor.calcite.v1_20_0.org.apache.calcite.plan.RelOptRuleOperand;
import org.apache.beam.vendor.calcite.v1_20_0.org.apache.calcite.rel.core.RelFactories;
import org.apache.beam.vendor.calcite.v1_20_0.org.apache.calcite.rel.rules.CalcMergeRule;
import org.apache.beam.vendor.calcite.v1_20_0.org.apache.calcite.tools.RelBuilderFactory;

/**
 * Planner rule to merge a {@link BeamCalcRel} with a {@link BeamCalcRel}. Subset of {@link
 * CalcMergeRule}.
 */
public class BeamCalcMergeRule extends RelOptRule {
  public static final BeamCalcMergeRule INSTANCE =
      new BeamCalcMergeRule(RelFactories.LOGICAL_BUILDER);

  public BeamCalcMergeRule(RelBuilderFactory relBuilderFactory) {
    super(
        operand(BeamCalcRel.class, operand(BeamCalcRel.class, any()), new RelOptRuleOperand[0]),
        relBuilderFactory,
        null);
  }

  @Override
  public void onMatch(RelOptRuleCall call) {
    CalcMergeRule.INSTANCE.onMatch(call);
  }
}
