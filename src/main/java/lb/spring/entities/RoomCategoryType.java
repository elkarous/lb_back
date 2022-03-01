package lb.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DefRoomCategory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomCategoryType {
    @Id
    @Column(name = "RoomCategoryTypeId")
    private int id;
    @Column(name = "RoomCategoryTypeLbl")
    private String roomCategoryTypeLbl;
}
