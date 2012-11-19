package org.wilyfrog.scalainvaders.cosas

class Ship{
  var lives = 3
  var isExploding = false
  var explodeTime:Float = 0

  def update (delta:Float){
    if (isExploding) {
      explodeTime += delta
      if (explodeTime > Explosion.ExplosionLiveTime){
        isExploding = false
        explodeTime = 0
      }
    }
  }

  def explode(time:Float){
    isExploding = true
    explodeTime = time
  }
}

object Ship{
  val ShipRadius:Float = 1
  val ShipSpeed:Float = 20
}
