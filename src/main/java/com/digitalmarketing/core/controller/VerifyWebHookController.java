package com.digitalmarketing.core.controller;

import com.digitalmarketing.core.model.User;
import com.digitalmarketing.core.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by Winiton Chanapolchai on 21/10/2560.
 */
@RestController
public class VerifyWebHookController {

    private LogService logService;

    @Autowired
    public VerifyWebHookController(LogService logService) {
        this.logService = logService;
    }

    @RequestMapping(value = "/verifyWebHook", method = {RequestMethod.GET, RequestMethod.POST})
    public void verify(
            @RequestHeader HashMap<String, String> requestHeader,
            @RequestBody(required = false) HashMap<String, String> requestBody) {

        logService.logEvent("RECEIVE_VERIFY_WEBHOOK");
        logService.logInfo("RequestHeader:" + requestHeader.toString());
        logService.logInfo("RequestBody:" + mapToString(requestBody));

    }

    private String mapToString(HashMap<String, String> map) {
        if(map != null){
            return map.toString();
        }
        return null;
    }


}
