package org.wilyfrog.scalainvaders.cosas

import com.badlogic.gdx.math.Vector3

class Shot (var position: Vector3, val isInvaderShot: Boolean){
  val ShotSpeed:Float = 10
  var hasLeftField = false

  def update(delta: Float) {
    val mult = if (isInvaderShot) 1 else -1
    position.z += ShotSpeed * delta * mult //TODO: pasarlo a inmutable?
  }
}
