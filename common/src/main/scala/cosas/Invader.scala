package org.wilyfrog.scalainvaders.cosas

import com.badlogic.gdx.math.Vector3

class Invader (var position: Vector3) {

  val InvaderRadius = 0.75f
  val InvaderSpeed = 1f
  val InvaderPoints = 40
  val StateMoveLeft = -1
  val StateMoveDown = 0
  val StateMoveRight = 1

  val StatesQeue = Array(-1,0,1,0)

  var stateIndex:Int = 0

 // val movement = Simulation.PLAYFIELDMAX / 2
  var movement:Float = Mundo.PlayFieldMaxX / 2

  def update ( delta: Float, speedMultiplier: Float) {
    movement += delta * InvaderSpeed * speedMultiplier

    var nextState = false

    if (StatesQeue(stateIndex) != StateMoveDown) {
      position.x += delta * InvaderSpeed * speedMultiplier * StatesQeue(stateIndex)
      if (movement > Mundo.PlayFieldMaxX)
          nextState = true
       }
     else{
       position.z += delta * InvaderSpeed * speedMultiplier
       if (movement > 1)
         nextState = true
     }

    if (nextState){
      stateIndex = (stateIndex + 1) % 4 //Move through the status queue
      movement = 0
    }
    
  }
}
