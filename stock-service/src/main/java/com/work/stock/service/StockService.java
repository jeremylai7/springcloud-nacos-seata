/*
 *  Copyright 1999-2021 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.work.stock.service;

import com.work.stock.entity.Stock;
import com.work.stock.repository.StockDAO;
import io.seata.core.context.RootContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Program Name: springcloud-nacos-seata
 * <p>
 * Description:
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/8/28 4:05 PM
 */
@Service
public class StockService {

    @Resource
    private StockDAO stockDAO;

    /**
     * 减库存
     *
     * @param count
     */
    @Transactional(rollbackFor = Exception.class)
    public void deduct(int count) {
        System.out.println("全局xid" + RootContext.getXID());
        if (count == 0) {
            throw new RuntimeException("异常:模拟业务异常:stock branch exception");
        }
        Long id = 1L;
        Stock stock = stockDAO.selectByPrimaryKey(id);
        stock.setNum(stock.getNum().subtract(BigDecimal.valueOf(count)));
        stock.setCreateTime(new Date());
        stockDAO.updateByPrimaryKey(stock);
    }
}
