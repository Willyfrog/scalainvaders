package org.wilyfrog.scalainvaders.cosas

import com.badlogic.gdx.math.Vector3

class Explosion (val position: Vector3){

  var aliveTime:Float = 0
  def update(delta:Float){
    aliveTime += delta
  }
  
  def isAlive():Boolean = aliveTime < Explosion.ExplosionLiveTime
}

object Explosion{
  val ExplosionLiveTime = 1
}
