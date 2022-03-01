package lb.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DefRoomCategory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomCategory {
    @Id
    @Column(name = "RoomCategoryId")
    private int id;
    @Column(name = "RoomCategoryCode", length = 10, insertable = false, updatable = false)
    private String roomCategoryCode;
    @Column(name = "RoomCategoryName", length = 40)
    private String roomCategoryName;
    @ManyToOne
    @JoinColumn(name = "RoomCategoryTypeId")
    private RoomCategoryType roomCategoryTypeId;
    @Column(name = "RoomCategoryCode")
    private int order;
}
