/**
 * Copyright (C) 2007 Google Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */

package cn.org.rapid_framework.shard.strategy.access;

import java.util.List;

import cn.org.rapid_framework.shard.Shard;
import cn.org.rapid_framework.shard.strategy.exit.ExitOperationsCollector;
import cn.org.rapid_framework.shard.strategy.exit.ExitStrategy;

public interface ShardAccessStrategy {
	<T> T apply(List<Shard> shards, ShardOperation operation,
			ExitStrategy<T> exitStrategy,
			ExitOperationsCollector exitOperationsCollector);
}
