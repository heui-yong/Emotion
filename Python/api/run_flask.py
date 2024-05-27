import sys
import os
from http import HTTPStatus
sys.path.append(os.path.dirname(os.path.abspath(os.path.dirname(__file__))))

from flask import Flask, jsonify, request  ## flask 라이브러리에서 Flask import

from model.emotion_model_predict import sentiment_predict

app = Flask(__name__)
params = None

@app.route('/emotion', methods=['POST'])
def post():
    global params
    if params is None:
        params = params = request.args.get('text')
        print(params)
    text = sentiment_predict(params)

    emotionData = {
    "inputText": params,
    "outputText": text
    }
    # return text
    params = None
    print(emotionData)
    return jsonify({"emotionData": emotionData, "status": HTTPStatus.OK})
 
if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)
    # app.run()