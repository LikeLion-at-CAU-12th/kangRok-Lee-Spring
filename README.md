# KangRok-Lee-Spring

## 23주차 과제
### 기능
- **사용자 관리**
    - 사용자는 이름, 이메일, 계정 생성일 정보를 포함하고 있다.
    - 사용자는 여러 개의 플레이리스트를 생성하고 관리할 수 있다.
- **곡 관리**
    - 각 곡은 제목, 가수, 앨범, 발매일 등의 정보를 포함한다.
    - 곡은 여러 장르에 속할 수 있다.
    - 곡의 좋아요 수를 기록한다.
- **플레이리스트 관리**
    - 사용자는 자신만의 플레이리스트를 생성하고 곡을 추가하거나 삭제할 수 있다.
    - 각 플레이리스트는 이름과 설명을 포함하며, 소유자가 있다.
- **검색 및 좋아요 기능**
    - 사용자는 곡, 앨범, 가수 명으로 검색할 수 있다.
    - 사용자는 곡을 좋아요 할 수 있고 그 시간을 저장하고 있다.
### 사용된 엔티티
- Member
- Song
- Album
- Artist
- Playlist
- Like
- Genre

### 엔티티 관계

Member - Playlist (1:N) <br>
Member - Like (1:N) <br>
Playlist - Song (N:M) <br>
Artist - Album (1:N) <br>
Artist - Song (1:N) <br>
Album - Song (1:N) <br>
Song - Genre (N:M) <br>
Like - Song (N:1) <br>

### 다대다(N:M) 관계를 구현한 방법
- Member - Song(좋아요) -> Like라는 중간 엔티티를 두어 ManyToOne 2개로 구현. 좋아요 누른 시간 liked_at을 저장하기 위함.
- Playlist - Song -> 중간 엔티티 없이 @ManyToMany로 지정
- Song - Genre -> 중간 엔티티 없이 @ManyToMany로 지정





