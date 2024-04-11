package com.okex.open.api.bean.other;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

@Data
public class Books {

    /**
     * "data": [{
     *         "asks": [ //上方
     *             ["8476.98", "415", "0", "13"],
     *             ["8477", "7", "0", "2"],
     *             ["8477.34", "85", "0", "1"]
     *         ],
     *         "bids": [ //下方
     *             ["8476.97", "256", "0", "12"],
     *             ["8475.55", "101", "0", "1"],
     *             ["8475.54", "100", "0", "1"]
     *         ],
     *         "ts": "1597026383085",
     *         "checksum": -855196043,
     *         "prevSeqId": -1,
     *         "seqId": 123456
     *     }]
     */
    private JSONArray asks;//卖方深度
    private JSONArray bids;//买方深度
    private String seqId;
    private Long ts;

}
