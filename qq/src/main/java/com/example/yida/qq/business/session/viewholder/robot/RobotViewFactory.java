package com.example.yida.qq.business.session.viewholder.robot;

import android.content.Context;

import com.example.yida.qq.business.robot.parser.elements.element.ImageElement;
import com.example.yida.qq.business.robot.parser.elements.element.TextElement;
import com.example.yida.qq.business.robot.parser.elements.group.LinkElement;

/**
 * Created by chenkang on 2017/6/29.
 */

class RobotViewFactory {

    static RobotTextView createRobotTextView(Context context, TextElement element, String textMsg) {
        return new RobotTextView(context, element, textMsg);
    }

    static RobotImageView createRobotImageView(Context context, ImageElement element, String url) {
        return new RobotImageView(context, element, url);
    }

    static RobotLinkView createRobotLinkView(Context context, LinkElement element) {
        return new RobotLinkView(context, element);
    }
}
