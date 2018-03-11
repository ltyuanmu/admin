package com.sugarfree.controller;

import com.github.pagehelper.PageInfo;
import com.sugarfree.dao.model.TActivity;
import com.sugarfree.dao.model.TActivityHelp;
import com.sugarfree.dao.model.TActivityJoin;
import com.sugarfree.invo.ActivityHelpInVo;
import com.sugarfree.invo.ActivityInVo;
import com.sugarfree.invo.ActivityJoinInVo;
import com.sugarfree.invo.BasePageParamInVo;
import com.sugarfree.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    public ActivityService activityService;

    /**
     * 查询活动列表
     * @return 活动列表
     */
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PageInfo<TActivity>> getActivityList(BasePageParamInVo inVo){
        PageInfo<TActivity> pageInfo = this.activityService.getActivityList(inVo);
        return ResponseEntity.ok(pageInfo);
    }

    /**
     * 通过活动列表查询活动参与人
     * @param inVo 活动id
     * @return 活动参与信息
     */
    @GetMapping(value = "/join/page", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PageInfo<TActivityJoin>> getActivityJoin(ActivityJoinInVo inVo){
        PageInfo<TActivityJoin> pageInfo = this.activityService.getActivityJoin(inVo);
        return ResponseEntity.ok(pageInfo);
    }

    /**
     * 通过参与人获得活动助力信息
     * @param inVo 活动参与io
     * @return 返回活动助力
     */
    @GetMapping(value = "/help/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PageInfo<TActivityHelp>> getActivityHelp(ActivityHelpInVo inVo){
        PageInfo<TActivityHelp> pageInfo = this.activityService.getActivityHelp(inVo);
        return ResponseEntity.ok(pageInfo);
    }

    /**
     * 添加活动
     * @param tActivity 活动表
     */
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity saveActivity(ActivityInVo tActivity) throws ParseException{
        this.activityService.saveActivity(tActivity);
        return ResponseEntity.ok().build();
    }
}
