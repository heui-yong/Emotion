import sys
import os
from http import HTTPStatus
sys.path.append(os.path.dirname(os.path.abspath(os.path.dirname(__file__))))

from flask import Flask, jsonify, redirect, render_template, request, url_for  ## flask 라이브러리에서 Flask import

from model.emotion_model_predict import sentiment_predict

funs1 = [{"text": "test1"}]

app = Flask(__name__)
params = None

@app.route('/emotion', methods=['POST'])
def post():
    global params
    if params is None:
        params = request.get_json()['text']
    text = sentiment_predict(params)

    data = {
    "data": params,
    "text": text
    }
    # return text
    params = None
    return jsonify({"data": data, "status": HTTPStatus.OK})

@app.route('/test', methods=['POST'])
def test():

    data = {
    "data": "test",
    "text": "test"
    }
    # return text
    params = None
    return jsonify({"data": "test", "status": HTTPStatus.OK})

 
if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)
    # app.run()