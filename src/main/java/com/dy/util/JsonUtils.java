package com.dy.util;

import com.dy.domain.Constant.Result;
import com.google.gson.JsonObject;

public class JsonUtils {

	/**
	 * Json 형태의 결과, 메시지를 성공 또는 실패 여부에 알맞은 형태로 반환한다.
	 * @param result - 결과 여부
	 * @return 결과, 메시지
	 */
	public static JsonObject getResultAndMessage(Result result) {

		JsonObject json = new JsonObject();
		json.addProperty("result", result.toString());

		switch (result) {
		case OK:
			json.addProperty("message", "정상적으로 처리되었습니다.");
			break;

		case FAIL:
			json.addProperty("message", "문제가 발생하였습니다. 다시 시도해 주세요.");
			break;

		default:
			break;
		}

		return json;
	}

}
