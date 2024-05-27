import pickle
import re
from konlpy.tag import Okt
import io
import os
import numpy as np

from tensorflow.keras.preprocessing.sequence import pad_sequences
from tensorflow.keras.models import load_model


def sentiment_predict(sentence):
    print(os.getcwd())
    model = load_model('model/emotion_model.h5')

    with open('model/emotion_tokenizer.pickle', 'rb') as handle:
        tokenizer = pickle.load(handle)

    okt = Okt()
    stopwords = ['의','가','이','은','들','는','좀','잘','걍','과','도','를','으로','자','에','와','한','하다']
    max_len = 40  
      
    sentence = re.sub(r'[^ㄱ-ㅎㅏ-ㅣ가-힣 ]','', sentence)
    sentence = okt.morphs(sentence, stem=True) # 토큰화
    sentence = [word for word in sentence if not word in stopwords] # 불용어 제거
    encoded = tokenizer.texts_to_sequences([sentence]) # 정수 인코딩
    pad_new = pad_sequences(encoded, maxlen = max_len) # 패딩
    score = model.predict(pad_new) # 예측
    max = np.argmax(score)

    if max == 0:
        return "부정의 감정입니다."
    elif max == 1:
        return "중립의 감정입니다."
    else :
        return "긍정의 감정입니다."