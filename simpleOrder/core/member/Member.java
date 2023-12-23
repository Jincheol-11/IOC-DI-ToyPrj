package simpleOrder.core.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 롬복 사용
// VO

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private Long id;
    private String name;
    private Grade grade;


}
