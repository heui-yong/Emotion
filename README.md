# 감정 분석
텍스트를 입력받고 긍정, 중립, 부정 3가지 감정을 분석해주는 프로젝트

## Python
 - Python의 Tensorflow를 사용하여 모델을 학습 
 - Flask를 사용해 API 구축
 - 학습을 위한 데이터셋
    >[한국어_단발성_대화_데이터셋](https://aihub.or.kr/aihubdata/data/view.do?dataSetSn=270)<br>
    [감성 대화 말뭉치](https://www.aihub.or.kr/aihubdata/data/view.do?currMenu=115&topMenu=100&dataSetSn=86)<br>
    [감정 분류를 위한 대화 음성 데이터셋](https://www.aihub.or.kr/aihubdata/data/view.do?currMenu=&topMenu=&dataSetSn=263&aihubDataSe=extrldata)


## Android 
  - Python에서 구축한 API로 통신
  - 간단한 UI 구성


## 사용법
 1. 데이터셋 다운로드 후 /data에 저장
 2. /data의 data_preprocessing 실행
 3. /model의 emotion_train 실행
 4. /api의 run_flask실행 후 api 동작 확인


