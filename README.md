# lifegame
Conway's Game of Life
* resource 폴더에 초기 셀 데이터가 있는 텍스트 파일을 넣습니다.
* 텍스트 파일은 'O'인 살아있는 셀과 '.'인 죽은 셀로 이루어져 있습니다.
* Main 클래스에서 실행 후 파일명과 세대 수를 입력하면 해당 세대수만큼 진행된 결과를 콘솔로 출력합니다.

## RULE(23-3)
* 해당 셀이 살아있을 때 인접한 셀 중 살아있는 셀이 2~3 개면 다음 세대에도 살아남는다.
* 죽은 셀 주위에 살아있는 셀이 3개면 다음세대에 살아난다.
* 그 외에는 다음세대에 죽는다(인접한 셀 중 살아있는 셀이 1개이거나 4개이상일때)

https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
https://ko.wikipedia.org/wiki/%EB%9D%BC%EC%9D%B4%ED%94%84_%EA%B2%8C%EC%9E%84

## 클래스 설명
### Cell
* 이전상태인 prevStatus 과 현재상태인 curStatus, 그리고 셀의 위치인 position 을 프로퍼티로 가지고 있습니다.
* `Cell.of(문자,y좌표,x좌표)` 로 셀을 생성합니다.
* 이전 상태로 현재 상태가 결정 됩니다.
* 출력 기준은 현재상태 입니다.
* 현재 세대의 모든 셀들에 대한 진행이 완료 된 후 다음 세대로 넘어가기 전 CellMatrix에 의해 현재상태가 이전상태로 이동합니다.

### CellColumns
* 가로 한줄의 셀을 나타냅니다.
* `putCell(Cell cell)`로 셀을 초기화 합니다.
* `checkStatus(int x)`로 x 좌표의 셀의 상태를 리턴합니다.
* `evolveProcess`로 가로 한줄의 셀을 돌면서 셀의 생사 여부를 판단해 해당 프로세스를 진행합니다.

### CellRows
* CellColumns의 집합입니다.
* CellColumns을 이용해 특정 위치의 셀의 상태를 얻습니다.
* 전체를 돌면서 CellColumns에게 셀의 상태를 변경하도록 명령합니다.

### CellMatrix
* 파일명을 받아서 파일을 읽어 전체 셀을 초기화 합니다.
* 경계 체크 후 CellRows에게 셀의 상태를 얻어오게 합니다.
* `evolveProcess()`로 CellRows에게 셀의 상태를 변경하도록 명령합니다.
* `makeResult()`를 이용해 `List<String>`형태의 현재 세대의 셀 결과를 리턴합니다.

### Direction
* `move(Cell curCell)`로 현재 셀을 받아 현재 셀에서 8방향의 위치를 리턴합니다.

### Position
* `ofMoved(int y, int x, Cell cell)`로 y, x 인자만큼 이동한 셀의 위치를 리턴합니다.
