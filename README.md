## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball_v1](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

# v1
## 구현할 기능 목록
### UI
- [x] baseball_v1.InputView
- [x] baseball_v1.ResultView
- [x] baseball_v1.GameOverView

### Logic
- [x] 랜덤한 수 생성하기
- [x] 계산 하기
    - [x] 스트라이크 계산하기
    - [x] 볼 계산하기
- [x] 재시작 하기

# v2
## 구현할 기능 목록
### Logic
- [x] 랜덤한 수 생성하기
- [ ] 입력한 수 validation
    - [ ] 숫자만 입력받았는지
    - [ ] 숫자가 1 ~ 9 사이인지
- [ ] 계산하기
    - [ ] 개별 포지션 검사하기
    - [ ] 볼 여부 검사하기

### UI
- [ ] View
    - [ ] Input
    - [ ] Result
    - [ ] GameOver